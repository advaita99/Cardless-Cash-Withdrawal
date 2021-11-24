from django.shortcuts import render
from feedback.models import Feedback
def feedback(request):
    obj=Feedback.objects.all()
    context = {
        'objval': obj,
    }
    return render(request,'feedback/feedback.html',context)




from .serializer import Android_serializer
from rest_framework.views import APIView,Response
from django.http import HttpResponse
from login.models import Login
import datetime

class Feedbackview(APIView):

    def get(self,request):
        s=Feedback.objects.all()
        ser=Android_serializer(s,many=True)
        return Response(ser.data)

    def post(self, request):
        obj = Feedback()
        obj.u_id =request.data["u_id"]
        obj.feedback = request.data["feedback"]
        obj.date = datetime.datetime.today()
        obj.save()

        return HttpResponse("ok")