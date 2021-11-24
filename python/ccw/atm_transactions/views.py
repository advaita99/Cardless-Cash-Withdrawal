from django.shortcuts import render
from atm_transactions.models import AtmTransactions
def atmtrans(request):
    obj=AtmTransactions.objects.all()
    context={
        'objval':obj,
    }
    return render(request,'atm_transactions/atm_transactions.html',context)




from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login
import datetime

class Atmtransactionview(APIView):

    def get(self,request):
        s=AtmTransactions.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)

    def post(self, request):
        obj = AtmTransactions()
        obj.atm_id =request.data["atm_id"]
        obj.u_id = request.data["u_id"]
        obj.ifsc_code = request.data["ifsc_code"]
        obj.account_number = request.data["account_number"]
        obj.date= datetime.datetime.today()
        obj.status =datetime.datetime.now().time()
        obj.amount = request.data["amount"]
        obj.status = "pending"
        obj.save()
        return HttpResponse("ok")