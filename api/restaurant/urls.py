from django.urls import path
from django.urls import path, include
from rest_framework import routers
from .views import *

router = routers.DefaultRouter()
router.register(r"product", ProductViewSet)
router.register(r"category", CategoryViewSet)

urlpatterns = [
    path("", include(router.urls)),
]
