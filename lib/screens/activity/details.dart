// ignore_for_file: prefer_const_constructors, camel_case_types

import 'package:flutter/material.dart';

class details extends StatelessWidget {
  const details({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Details'),
      ),
      body: Center(child: Text('Details')),
    );
  }
}
