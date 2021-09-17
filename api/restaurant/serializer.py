from rest_framework import serializers
from .models import *


class ProductSerializer(serializers.ModelSerializer):
    class Meta:
        model = Product
        fields = "__all__"


class CategorySerializer(serializers.ModelSerializer):

    products = ProductSerializer(many=True)

    class Meta:
        model = Category
        fields = ["id", "name", "image", "state", "products"]
