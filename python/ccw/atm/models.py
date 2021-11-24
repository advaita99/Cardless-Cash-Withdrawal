from django.db import models

# Create your models here.

class Atm(models.Model):
    atm_id = models.AutoField(primary_key=True)
    b_id = models.IntegerField()
    location = models.CharField(max_length=25)
    longitude = models.CharField(max_length=25)
    latitude = models.CharField(max_length=25)
    status = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'atm'

