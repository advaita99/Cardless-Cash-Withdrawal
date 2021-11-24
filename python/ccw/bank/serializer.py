from rest_framework import serializers
from .models import Bank

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Bank
        fields = '__all__'