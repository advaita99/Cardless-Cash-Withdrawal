from rest_framework import serializers
from .models import Rating

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Rating
        fields = '__all__'