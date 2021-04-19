import 'package:flutter/material.dart';

class PrincipalPageTemp extends StatelessWidget {
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
  final opciones = ['Uno', 'Dos', 'Tres', 'Cuatro', 'Cinco'];
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: _crearItems(),
    );
  }

  List<Widget> _crearItems() {
    List<Widget> lista = new List<Widget>();
    //Recorremos la lista de opciones
    for (String opt in opciones) {
      final tempWidget = ListTile(
        title: Text(opt),
        leading: Icon(Icons.account_balance_wallet),
        trailing: Icon(Icons.keyboard_arrow_right),
      );
      lista.add(tempWidget);
      lista.add(Divider());
    }
    //Devolvemos la lista de Widgets con las opciones
    return lista;
  }
}
