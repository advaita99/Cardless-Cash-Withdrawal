from django.shortcuts import render
from complaint.models import Complaint
def comp(request):
    obj = Complaint.objects.all()
    context = {
        'objval': obj,
    }
    return render(request,'Complaint/viewcomplaintfromuser.html',context)

from reply.models import Reply
import datetime
def postreply(request,idd):
    obj = Complaint.objects.get(c_id=idd)
    context = {
        'objval': obj,
    }
    if request.method=="POST":
        obj=Complaint.objects.get(c_id=idd)
        obj.status="replied"
        obj.save()

    if request.method=="POST":
        ob=Reply()
        ob.c_id=obj.c_id
        ob.date=datetime.datetime.today()
        ob.time=datetime.datetime.now().time()
        ob.reply=request.POST.get("reply")
        ob.save()
        return comp(request)
    return render(request, 'Complaint/postreply.html', context)


from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login
import datetime

class Complaintrview(APIView):

    def get(self,request):
        s=Complaint.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)

    def post(self, request):
        obj = Complaint()
        obj.u_id =request.data["u_id"]
        obj.date = datetime.datetime.today()
        obj.time = datetime.datetime.now().time()
        obj.complaint = request.data["complaint"]
        obj.status = "pending"
        obj.save()

        return HttpResponse("ok")