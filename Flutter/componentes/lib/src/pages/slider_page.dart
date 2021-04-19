import 'package:flutter/material.dart';

class SliderPage extends StatefulWidget {
  @override
  _SliderPageState createState() => _SliderPageState();
}

class _SliderPageState extends State<SliderPage> {
  double _valorSlider = 100.0;
  bool _valorCheck = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Slider'),
      ),
      body: Container(
        padding: EdgeInsets.only(top: 50.0),
        child: Column(
          children: [
            _crearSlider(),
            _checkBox(),
            _crearSwitch(),
            _crearImagen()
          ],
        ),
      ),
    );
  }

  _crearSlider() {
    return Slider(
      activeColor: Colors.indigoAccent,
      label: 'Tamaño de la imagen',
      value: _valorSlider,
      onChanged: (_valorCheck)
          ? null
          : (valor) {
              setState(() {
                _valorSlider = valor;
              });
            },
      min: 10.0,
      max: 400.0,
    );
  }

  _checkBox() {
    //return Checkbox(
    //  value: _valorCheck,
    //  onChanged: (interruptor) {
    //    setState(() {
    //      _valorCheck = interruptor;
    //    });
    //  },
    //);
    return CheckboxListTile(
      title: Text('Bloquear Slider'),
      value: _valorCheck,
      onChanged: (interruptor) {
        setState(() {
          _valorCheck = interruptor;
        });
      },
    );
  }

  _crearSwitch() {
    return SwitchListTile(
      title: Text('Bloquear Slider'),
      value: _valorCheck,
      onChanged: (interruptor) {
        setState(() {
          _valorCheck = interruptor;
        });
      },
    );
  }

  _crearImagen() {
    return Image(
      image: NetworkImage('http://pngimg.com/uploads/batman/batman_PNG111.png'),
      width: _valorSlider,
      fit: BoxFit.contain,
    );
  }
}
