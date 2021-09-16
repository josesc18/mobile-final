from django.contrib import admin
from .models import *

# Register your models here.
class CategoryAdmin(admin.ModelAdmin):
    list_display = ("id", "name", "state")


admin.site.register(Category, CategoryAdmin)
