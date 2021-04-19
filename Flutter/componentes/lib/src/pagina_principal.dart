import 'package:flutter/material.dart';

class PrincipalPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Componentes'),
      ),
      body: _ListaComponentes(),
    );
  }
}

class _ListaComponentes extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: [
        ListTile(
          title: Text('Alertas'),
          subtitle: Text('Muestra una alerta'),
          leading: Icon(Icons.notifications, color: Colors.blue),
          trailing: Icon(Icons.keyboard_arrow_right),
          onTap: () {
            Navigator.pushNamed(context, '/alertas');
          },
        ),
        Divider(),
        ListTile(
          title: Text('Avatar'),
          subtitle: Text('Componente Avatar'),
          leading: Icon(Icons.person, color: Colors.blue),
          trailing: Icon(Icons.keyboard_arrow_right),
          onTap: () {
            Navigator.pushNamed(context, '/avatar');
          },
        ),
        Divider(),
        ListTile(
          title: Text('CardViews'),
          subtitle: Text('Vistas de tarjeta'),
          leading: Icon(Icons.card_giftcard, color: Colors.blue),
          trailing: Icon(Icons.keyboard_arrow_right),
          onTap: () {
            Navigator.pushNamed(context, '/tarjetas');
          },
        ),
        Divider(),
        ListTile(
          title: Text('Formulario'),
          subtitle: Text('Introduce tus datos'),
          leading: Icon(
            Icons.format_align_justify,
            color: Colors.blue,
          ),
          trailing: Icon(Icons.keyboard_arrow_right),
          onTap: () {
            Navigator.pushNamed(context, '/formulario');
          },
        ),
        Divider(),
        ListTile(
          title: Text('Slider'),
          subtitle: Text('Cambia el tamaño de tu imagen'),
          leading: Icon(
            Icons.image_aspect_ratio,
            color: Colors.blue,
          ),
          trailing: Icon(Icons.image_outlined),
          onTap: () {
            Navigator.pushNamed(context, '/slider');
          },
        ),
      ],
    );
  }
}
