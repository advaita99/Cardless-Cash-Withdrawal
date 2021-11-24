from django.shortcuts import render

# Create your views here.
from request.models import Request
import datetime
from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login

def viewrequest(request):
    obj=Request.objects.all()
    context = {
        'objval': obj,
    }
    return render(request,'request/manage_request.html',context)

def approve(request,idd):
    obj=Request.objects.get(r_id=idd)
    obj.status="approved"
    obj.save()
    return viewrequest(request)


def reject(request, idd):
    obj = Request.objects.get(r_id=idd)
    obj.status = "rejected"
    obj.save()
    return viewrequest(request)


class Requestview(APIView):

    def get(self,request):
        s=Request.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)


    def post(self, request):
        obj = Request()
        obj.u_id =request.data["u_id"]
        obj.b_id = request.data["b_id"]
        obj.date = datetime.datetime.today()
        obj.type_of_account = request.data["type"]
        obj.aadhar_card= request.data["aadhar"]
        obj.status="requested"
        obj.save()

        return HttpResponse("ok")
