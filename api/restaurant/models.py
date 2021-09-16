from django.db import models
from django.db.models.deletion import CASCADE
from django.db.models.fields.related import ForeignKey

# Create your models here.
class Category(models.Model):
    name = models.CharField(max_length=200)
    image = models.ImageField(upload_to="categories/")
    state = models.BooleanField(default=True)

    def __str__(self):
        return self.name


class Product(models.Model):
    name = models.CharField(max_length=200)
    image = models.ImageField(upload_to="products/")
    price = models.DecimalField(max_digits=10, decimal_places=2)
    time = models.CharField(max_length=200)
    category = ForeignKey(Category, on_delete=CASCADE)
    state = models.BooleanField(default=True)

    def __str__(self):
        return self.name
