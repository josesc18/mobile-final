from django.contrib import admin
from .models import *

# Register your models here.
class CategoryAdmin(admin.ModelAdmin):
    list_display = ("id", "name", "state")


class ProductAdmin(admin.ModelAdmin):
    list_display = ("id", "name", "category", "price", "time", "state")


admin.site.register(Category, CategoryAdmin)
admin.site.register(Product, ProductAdmin)
