import 'package:flutter/material.dart';

class AvatarPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Avatar Page'),
        centerTitle: true,
        actions: [
          Container(
            margin: EdgeInsets.all(10.0),
            child: CircleAvatar(
              backgroundImage: NetworkImage(
                  'https://sc2.elpais.com.uy/files/article_default_content/uploads/2020/10/23/5f92df36e8413.jpeg'),
              radius: 25.0,
            ),
          ),
          Container(
            margin: EdgeInsets.all(10.0),
            child: CircleAvatar(
              child: Text('AR'),
              backgroundColor: Colors.amber[100],
            ),
          ),
        ],
      ),
      body: Center(
        child: FadeInImage(
          image: NetworkImage(
              'https://phantom-elmundo.unidadeditorial.es/e012c0a6c79d74acf154f496ff0bd6ee/crop/16x27/2019x1363/resize/473/f/webp/assets/multimedia/imagenes/2020/10/19/16030964846762.jpg'),
          placeholder: AssetImage('assets/jar-loading.gif'),
          fadeInDuration: Duration(seconds: 5),
        ),
      ),
    );
  }
}
