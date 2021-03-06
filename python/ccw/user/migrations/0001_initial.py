# Generated by Django 3.1.6 on 2021-03-25 10:26

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='User',
            fields=[
                ('u_id', models.AutoField(primary_key=True, serialize=False)),
                ('l_id', models.IntegerField()),
                ('name', models.CharField(max_length=25)),
                ('date_of_birth', models.DateField()),
                ('email', models.CharField(max_length=25)),
                ('phone_number', models.CharField(max_length=20)),
                ('status', models.CharField(max_length=100)),
            ],
            options={
                'db_table': 'user',
                'managed': False,
            },
        ),
    ]
