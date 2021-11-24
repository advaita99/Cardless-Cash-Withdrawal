from rest_framework import serializers
from .models import Reply

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = Reply
        fields = '__all__'