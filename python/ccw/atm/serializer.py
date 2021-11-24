from rest_framework import serializers
from .models import Atm

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Atm
        fields = '__all__'