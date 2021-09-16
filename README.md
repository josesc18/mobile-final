# Trabajo Final del Curso

Desarrollo de Aplicación Móvil Para La Gestión De Toma De Pedidos

## OBJETIVO DEL TRABAJO

Create a virtual environment and install the dependencies:
```sh

Desarrollar una aplicación móvil en entorno Android y SqLite que permita la gestión de toma
de pedidos y sirva como herramienta tecnológica viable para mejorar el proceso de atención 
al cliente en una cafetería.

```

## PLANTEAMIENTO DEL TRABAJO

```sh

Según las herramientas y controles desarrollados en el curso se plantea el siguiente caso: 
Debido a que la mayoría de los consumidores actuales no se le debe ofrecer productos o 
servicios sino experiencias, se plantea en el presente trabajo el desarrollo de una aplicación 
móvil que brinde el servicio de pedidos, donde los usuarios una vez dentro del
establecimiento podrán a través de la aplicación elegir los productos, ver los precios, la 
disponibilidad de los servicios que se ofrecen y realizar el respectivo pedido por medio de su 
dispositivo móvil. Esta aplicación no contempla métodos de pago el establecimiento cuenta 
con conexión Wifi gratis.

```

# Este proyecto esta bajo python 3.7.4

## INICIALIZAR API
```sh
# Iniciar trabajo en Windows
cd api
python -m venv venv
api\venv\Scripts\activate.bat
pip install -r requirements.txt
python manage.py migrate

#Crear Administrador de Sistema
python manage.py createsuperuser

#Iniciar servidor en carpeta mobile-final/api
python manage.py runserver 0.0.0.0:8000


```