import 'package:flutter/material.dart';

class SegundaPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Segunda Pagina'),
      ),
      body: Center(
        child: RaisedButton(
          color: Colors.lightGreen,
          child: Text('Volver a la pagina 1'),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
      ),
    );
  }
}
