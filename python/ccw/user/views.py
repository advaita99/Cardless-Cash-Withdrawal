from django.shortcuts import render
from user.models import User
def user(request):
    obj=User.objects.all()
    context = {
        'objval': obj,
    }
    return render(request,'user/view_user.html',context)


def uaccept(request,idd):
    obj=User.objects.get(u_id=idd)
    obj.status="accept"
    obj.save()
    return user(request)


def ureject(request,idd):
    obj=User.objects.get(u_id=idd)
    obj.status="rejected"
    obj.save()
    return user(request)



from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login

class Userview(APIView):

    def get(self,request):
        s=User.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)

    def post(self, request):
        obj = User()
        obj.name =request.data["name"]
        obj.date_of_birth = request.data["dob"]
        obj.email = request.data["email"]
        obj.phone_number = request.data["phone"]
        obj.status= "pending"
        obj.save()

        ob=Login()
        ob.usename=request.data["email"]
        ob.password = request.data["password"]
        ob.status = "pending"
        ob.type = "pending"
        ob.save()
        return HttpResponse("ok")