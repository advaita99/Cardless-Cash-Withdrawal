from django.shortcuts import render
from pin.models import Pin


def pin(request):
    return render(request,'pin/pi')



from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login

class Pinview(APIView):

    def get(self,request):
        s=Pin.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)

    def post(self, request):
        obj = Pin()
        obj.u_id = request.data["u_id"]
        obj.account_number = request.data["account_number"]
        obj.pin=request.data["pin"]
        obj.status = "generated"
        obj.save()

        return HttpResponse("ok")
