from django.db import models

# Create your models here.
class Request(models.Model):
    r_id = models.AutoField(primary_key=True)
    u_id = models.IntegerField()
    b_id = models.IntegerField()
    date = models.DateField()
    type_of_account = models.CharField(max_length=30)
    aadhar_card = models.CharField(max_length=30)
    status = models.CharField(max_length=30)

    class Meta:
        managed = False
        db_table = 'request'
