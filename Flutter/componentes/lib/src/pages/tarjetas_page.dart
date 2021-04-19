import 'package:flutter/material.dart';

class TarjetasPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Tarjetas'),
      ),
      body: ListView(
        padding: EdgeInsets.all(10.0),
        children: [
          _tarjetaTipo1(),
          SizedBox(
            height: 30.0,
          ),
          _tarjetaTipo2(),
          SizedBox(
            height: 30.0,
          ),
          _tarjetaTipo1(),
          SizedBox(
            height: 30.0,
          ),
          _tarjetaTipo2(),
          SizedBox(
            height: 30.0,
          ),
          _tarjetaTipo1(),
          SizedBox(
            height: 30.0,
          ),
          _tarjetaTipo2(),
          SizedBox(
            height: 30.0,
          ),
          _tarjetaTipo1(),
          SizedBox(
            height: 30.0,
          ),
          _tarjetaTipo2(),
          SizedBox(
            height: 30.0,
          ),
        ],
      ),
    );
  }

  Widget _tarjetaTipo1() {
    return Card(
      color: Colors.blue[50],
      elevation: 5.0,
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20.0)),
      child: Column(
        children: [
          ListTile(
            leading: Icon(
              Icons.photo_album,
              color: Colors.blue,
            ),
            title: Text('Soy el titulo de esta tarjeta'),
            subtitle: Text(
                'Aqui estamos con la descripcion de la tarjeta qure quiero que vean para tener una idea de lo que quiero mostarles'),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.end,
            children: [
              FlatButton(
                child: Text('Cancelar'),
                onPressed: () {},
                textColor: Colors.blue,
              ),
              FlatButton(
                child: Text('Ok'),
                onPressed: () {},
                textColor: Colors.blue,
              ),
            ],
          )
        ],
      ),
    );
  }

  Widget _tarjetaTipo2() {
    final card = Container(
      child: Column(
        children: [
          FadeInImage(
            image: NetworkImage(
                'https://learn.zoner.com/wp-content/uploads/2018/08/landscape-photography-at-every-hour-part-ii-photographing-landscapes-in-rain-or-shine.jpg'),
            placeholder: AssetImage('assets/jar-loading.gif'),
            //height: 300.0,
            fit: BoxFit.cover,
          ),
          Container(
            padding: EdgeInsets.all(10.0),
            child: Text('No tengo ni idea de que poner'),
          )
        ],
      ),
    );

    return Container(
      decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(30.0),
          color: Colors.white,
          boxShadow: <BoxShadow>[
            BoxShadow(
                color: Colors.black,
                blurRadius: 10.0,
                spreadRadius: 2.0,
                offset: Offset(2.0, 2.0))
          ]),
      child: ClipRRect(
        child: card,
        borderRadius: BorderRadius.circular(30.0),
      ),
    );
  }
}
