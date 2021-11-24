from rest_framework import serializers
from .models import Request

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Request
        fields = '__all__'