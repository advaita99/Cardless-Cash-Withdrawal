from django.shortcuts import render
from reply.models import Reply
import datetime
def reply(request):
    if request.method =="POST":
        obj=Reply()
        obj.c_id=1
        obj.reply=request.POST.get("rep")
        obj.date = datetime.date.today()
        obj.time = datetime.datetime.now()
    return render(request,'reply/postreply.html')




from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login

class Replyview(APIView):

    def get(self,request):
        s=Reply.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)
