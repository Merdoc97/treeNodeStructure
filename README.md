# treeNodeStructure
Current algorithm reparse any entity (should adopted) with names in comaseparated structure 
and rebuild it in tree view (adopted for JSON structure)
This algorithm can has any child with any count of childs
Tree algorithms get from link
https://github.com/gt4dev/yet-another-tree-structure
Example of work:
gets as argument current values<br>
 private static List<TestEntity> testData() {<br>
        return new ArrayList<>(Arrays.asList(new TestEntity(1, "test,test2,test3,test41"),<br>
                new TestEntity(2, "test,test2,test3,test44"),<br>
                new TestEntity(3, "test,test2,test4"),<br>
                new TestEntity(4, "test2,test3,test4"),<br>
                new TestEntity(6, "test,test2,test4,test5,test8"),<br>
                new TestEntity(10, "test,test2,test4,test6,test7"),<br>
                new TestEntity(11, "test,test2,test4,test6,test10"),<br>
                new TestEntity(7, "test2,test3,test5"),<br>
                new TestEntity(8, "test2,test3,test5,test6")));<br>
    }<br>
and represent it in tree values example:<br>
[<br>
  {<br>
    "viewName": "test",<br>
    "children": [<br>
      {<br>
        "viewName": "test2",<br>
        "children": [<br>
          {<br>
            "viewName": "test3",<br>
            "children": [<br>
              {<br>
                "viewName": "test41",<br>
                "idObject": {<br>
                  "id": 1,<br>
                  "name": "test,test2,test3,test41"<br>
                }<br>
              },<br>
              {<br>
                "viewName": "test44",<br>
                "idObject": {<br>
                  "id": 2,<br>
                  "name": "test,test2,test3,test44"<br>
                }<br>
              }<br>
            ]<br>
          },<br>
          {<br>
            "viewName": "test4",<br>
            "children": [<br>
              {<br>
                "viewName": "test5",<br>
                "children": [<br>
                  {<br>
                    "viewName": "test8",<br>
                    "idObject": {<br>
                      "id": 6,<br>
                      "name": "test,test2,test4,test5,test8"<br>
                    }<br>
                  }<br>
                ]<br>
              },<br>
              {<br>
                "viewName": "test6",<br>
                "children": [<br>
                  {<br>
                    "viewName": "test10",<br>
                    "idObject": {<br>
                      "id": 11,<br>
                      "name": "test,test2,test4,test6,test10"<br>
                    }<br>
                  },<br>
                  {<br>
                    "viewName": "test7",<br>
                    "idObject": {<br>
                      "id": 10,<br>
                      "name": "test,test2,test4,test6,test7"<br>
                    }<br>
                  }<br>
                ]<br>
              }<br>
            ],<br>
            "idObject": {<br>
              "id": 3,<br>
              "name": "test,test2,test4"<br>
            }<br>
          }<br>
        ]<br>
      }<br>
    ]<br>
  },<br>
  {<br>
    "viewName": "test2",<br>
    "children": [<br>
      {<br>
        "viewName": "test3",<br>
        "children": [<br>
          {<br>
            "viewName": "test4",<br>
            "idObject": {<br>
              "id": 4,<br>
              "name": "test2,test3,test4"<br>
            }<br>
          },<br>
          {<br>
            "viewName": "test5",<br>
            "children": [<br>
              {<br>
                "viewName": "test6",<br>
                "idObject": {<br>
                  "id": 8,<br>
                  "name": "test2,test3,test5,test6"<br>
                }<br>
              }<br>
            ],<br>
            "idObject": {<br>
              "id": 7,<br>
              "name": "test2,test3,test5"<br>
            }<br>
          }<br>
        ]<br>
      }<br>
    ]<br>
  }<br>
]<br>
thanks gt4dev ;
