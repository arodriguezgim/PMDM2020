import 'package:flutter/material.dart';

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
            appBar: AppBar(
              centerTitle: true,
              title: Text('Primer Flutter'),
            ),
            body: Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    'Esto es el contador del boton:',
                    style: TextStyle(fontSize: 25.0),
                  ),
                  SizedBox(
                    height: 30.0,
                  ),
                  Text(
                    contador.toString(),
                    style: TextStyle(fontSize: 30.0),
                  ),
                ],
              ),
            ),
            floatingActionButton: _botonera()));
  }

  Widget _botonera() {
    return Row(
      mainAxisAlignment: MainAxisAlignment.end,
      children: [
        SizedBox(
          width: 30.0,
        ),
        FloatingActionButton(
            child: Icon(Icons.exposure_zero),
            onPressed: () {
              _resetear();
            }),
        Expanded(child: SizedBox()),
        FloatingActionButton(
            child: Icon(Icons.remove),
            onPressed: () {
              _disminuir();
            }),
        SizedBox(
          width: 5.0,
        ),
        FloatingActionButton(
            child: Icon(Icons.add),
            onPressed: () {
              _aumentar();
            }),
      ],
    );
  }

  void _aumentar() {
    setState(() {
      contador++;
    });
  }

  void _disminuir() {
    setState(() {
      contador--;
    });
  }

  void _resetear() {
    setState(() {
      contador = 0;
    });
  }
}
