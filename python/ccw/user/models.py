from django.db import models

# Create your models here.
class User(models.Model):
    u_id = models.AutoField(primary_key=True)
    l_id = models.IntegerField()
    name = models.CharField(max_length=25)
    date_of_birth = models.DateField()
    email = models.CharField(max_length=25)
    phone_number = models.CharField(max_length=20)
    status = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'user'


