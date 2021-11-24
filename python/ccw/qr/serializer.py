from rest_framework import serializers
from .models import Qr

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Qr
        fields = '__all__'