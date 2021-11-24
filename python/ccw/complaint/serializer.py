from rest_framework import serializers
from .models import Complaint

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Complaint
        fields = '__all__'