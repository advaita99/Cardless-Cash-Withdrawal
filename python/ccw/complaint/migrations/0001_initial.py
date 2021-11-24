# Generated by Django 3.1.6 on 2021-03-25 10:26

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Complaint',
            fields=[
                ('c_id', models.AutoField(primary_key=True, serialize=False)),
                ('u_id', models.IntegerField()),
                ('date', models.DateField()),
                ('time', models.TimeField()),
                ('complaint', models.CharField(max_length=25)),
            ],
            options={
                'db_table': 'complaint',
                'managed': False,
            },
        ),
    ]
