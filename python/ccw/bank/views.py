from django.shortcuts import render
from bank.models import Bank
import datetime

from login.models import Login


def bank(request):
    if request.method == "POST":
        ob= Login()
        ob.usename=request.POST.get("username")
        ob.password=request.POST.get("password")
        ob.type="bank"
        ob.status=datetime.datetime.today()
        ob.save()
        obj = Bank()
        obj.l_id=ob.l_id
        obj.bank_name = request.POST.get("nam")
        obj.reg_no = request.POST.get("regno")
        obj.address = request.POST.get("add")
        obj.ifsc_code = request.POST.get("IFSC")
        obj.phone_number = request.POST.get("phno")
        obj.email = request.POST.get("email")
        obj.save()
    return render(request,'bank/bankreg.html')
def managebank(request):
    obj=Bank.objects.all()
    context = {
        'objval': obj,
    }
    return render(request,'bank/manage_bank.html',context)
def approve(request,idd):
    obj=Bank.objects.get(b_id=idd)
    obj.status="approved"
    obj.save()
    return managebank(request)
def reject(request,idd):
    obj=Bank.objects.get(b_id=idd)
    obj.status="rejected"
    obj.save()
    return managebank(request)


from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login

class Bankview(APIView):

    def get(self,request):
        s=Bank.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)

