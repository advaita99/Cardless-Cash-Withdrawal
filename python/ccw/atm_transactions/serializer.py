from rest_framework import serializers
from .models import AtmTransactions

class Android_serializer(serializers.ModelSerializer):
    class Meta:
        model = AtmTransactions
        fields = '__all__'