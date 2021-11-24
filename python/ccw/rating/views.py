from django.shortcuts import render
from rating.models import Rating
def rating(request):
    obj=Rating.objects.all()
    context = {
        'objval': obj,
    }
    return render(request,'rating/rating.html',context)


from .serializer import Android_serializer
from rest_framework.views import APIView, Response
from django.http import HttpResponse
from login.models import Login


class Ratingview(APIView):

    def get(self, request):
        s = Rating.objects.all()
        ser = Android_serializer(s, many=True)
        return Response(ser.data)

    def post(self, request):
        obj = Rating()
        obj.u_id = request.data["u_id"]
        obj.rating = request.data["ra"]
        obj.save()

        return HttpResponse("ok")
