from rest_framework import serializers
from .models import Pin

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Pin
        fields = '__all__'