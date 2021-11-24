from rest_framework import serializers
from .models import Login

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Login
        fields = '__all__'