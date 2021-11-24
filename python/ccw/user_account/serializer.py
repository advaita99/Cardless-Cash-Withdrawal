from rest_framework import serializers
from .models import UserAccount

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = UserAccount
        fields = '__all__'