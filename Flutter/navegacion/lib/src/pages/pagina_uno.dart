import 'package:flutter/material.dart';
import 'package:navegacion/src/pages/pagina_dos.dart';

class PrimeraPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Primera Pagina'),
      ),
      body: Center(
        child: RaisedButton(
          textColor: Colors.red,
          color: Colors.amber[200],
          child: Text('Ir a Pagina 2'),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => SegundaPage()),
            );
          },
        ),
      ),
    );
  }
}
