from django.shortcuts import render
from atm.models import Atm


from pyqrcode import QRCode
from ccw import settings
import qrcode




def regatm(request):
    if request.method == "POST":
        obj = Atm()
        obj.b_id= request.POST.get("bi")
        obj.location=request.POST.get("location")
        obj.latitude=request.POST.get("latitude")
        obj.longitude=request.POST.get("longitude")
        obj.save()

        idd = obj.atm_id

        i = str(idd) + ".png"

        qr = qrcode.QRCode(
            version=1,
            box_size=10,
            border=5)
        qr.add_data(idd)
        qr.make(fit=True)
        img = qr.make_image(fill='black', back_color='white')
        imgpath = settings.BASE_DIR + settings.STATIC_URL + i
        print(imgpath)
        img.save(imgpath)

    return render(request,'atm/atm_register.html')


def viewatm(request):
    obj = Atm.objects.all()
    context = {
        'objval':obj,
    }
    return render(request,'atm/view_atm.html',context)
def manageatm(request):
    obj = Atm.objects.all()
    context = {
        'objval':obj,
    }
    return render(request,'atm/manage_atm.html',context)
def update(request,idd):
    obj = Atm.objects.get(atm_id=idd)
    context = {
        'objval': obj,
    }
    if request.method=="POST":
        obj = Atm.objects.get(atm_id=idd)
        obj.b_id = request.POST.get("bi")
        obj.location = request.POST.get("location")
        obj.latitude = request.POST.get("latitude")
        obj.longitude = request.POST.get("longitude")
        obj.save()
        return manageatm(request)
    return render(request, 'atm/update.html',context)
def block(request,idd):
    obj=Atm.objects.get(atm_id=idd)
    obj.status="blocked"
    obj.save()
    return manageatm(request)





from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login

class Atmview(APIView):

    def get(self,request):
        s=Atm.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)

    def post(self, request):
        obj = Atm()
        obj.name =request.data["name"]
        obj.date_of_birth = request.data["dob"]
        obj.email = request.data["email"]
        obj.phone_number = request.data["phone"]
        obj.status= "pending"
        obj.save()
        return HttpResponse("ok")