// ignore_for_file: camel_case_types, prefer_const_constructors

import 'package:flutter/material.dart';
// ignore: unused_import
// import 'jobs_card.dart';
import 'jobs_card.dart'; // Assuming you have a Job widget defined in this file
class taken extends StatefulWidget {
  const taken({super.key});

  @override
  State<taken> createState() => _takenState();
}

class _takenState extends State<taken> {
  @override
  Widget build(BuildContext context) {
    return Column(
      children: const [
        /*
        Job(
          position: 'Graphics Designer',
          companyName: 'RDX',
          date: DateTime(2013, 2, 1),
          type: 'taken',
        ),
        Job(
          position: 'Flutter Developer',
          companyName: 'ABC',
          date: DateTime(2013, 2, 1),
          type: 'taken',
        ),
        Job(
          position: 'Web Designer',
          companyName: 'AAU',
          date: DateTime(2013, 2, 1),
          type: 'taken',
        ),
        */
      ],
    );
  }
}
