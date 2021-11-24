from django.db import models

# Create your models here.

class Complaint(models.Model):
    c_id = models.AutoField(primary_key=True)
    u_id = models.IntegerField()
    date = models.DateField()
    time = models.TimeField()
    complaint = models.CharField(max_length=25)
    status = models.CharField(max_length=30)


    class Meta:
        managed = False
        db_table = 'complaint'
