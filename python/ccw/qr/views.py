from django.shortcuts import render

from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login
from .models import Qr

class Qrview(APIView):

    def get(self,request):
        s=Qr.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)
