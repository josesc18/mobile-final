from rest_framework.response import Response
from django.shortcuts import render
from rest_framework.pagination import PageNumberPagination
from rest_framework import viewsets
from .serializer import *
from .models import *

# Create your views here.


# class ProductPagination(PageNumberPagination):
#     page_size = 3
#     page_size_query_param = "page_size"
#     page_query_param = "page"
#     max_page_size = 10

#     def get_paginated_response(self, data):

#         return Response(
#             {
#                 "results": data,
#                 "pagination": self.page.paginator.count,
#                 "page_size": self.page.paginator.per_page,
#                 "page": self.page.start_index() // self.page.paginator.per_page + 1,
#             }
#         )


class ProductViewSet(viewsets.ModelViewSet):
    # pagination_class = ProductPagination
    queryset = Product.objects.all()
    serializer_class = ProductSerializer


class CategoryViewSet(viewsets.ModelViewSet):
    queryset = Category.objects.all()
    serializer_class = CategorySerializer
