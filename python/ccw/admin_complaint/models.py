from django.db import models

# Create your models here.
class AdminComplaint(models.Model):
    ca_id = models.AutoField(primary_key=True)
    b_id = models.IntegerField()
    complaint = models.CharField(max_length=100)
    status = models.CharField(max_length=30)
    date = models.DateField()
    time = models.TimeField()

    class Meta:
        managed = False
        db_table = 'admin_complaint'

