# treeNodeStructure
Current algorithm reparse any entity (should adopted) with names in comaseparated structure 
and rebuild it in tree view (adopted for JSON structure)
This algorithm can has any child with any count of childs
Tree algorithms get from link
https://github.com/gt4dev/yet-another-tree-structure
Example of work:
gets as argument current values
 private static List<TestEntity> testData() {
        return new ArrayList<>(Arrays.asList(new TestEntity(1, "test,test2,test3,test41"),
                new TestEntity(2, "test,test2,test3,test44"),
                new TestEntity(3, "test,test2,test4"),
                new TestEntity(4, "test2,test3,test4"),
                new TestEntity(6, "test,test2,test4,test5,test8"),
                new TestEntity(10, "test,test2,test4,test6,test7"),
                new TestEntity(11, "test,test2,test4,test6,test10"),
                new TestEntity(7, "test2,test3,test5"),
                new TestEntity(8, "test2,test3,test5,test6")));
    }
and represent it in tree values example:
[
  {
    "viewName": "test",
    "children": [
      {
        "viewName": "test2",
        "children": [
          {
            "viewName": "test3",
            "children": [
              {
                "viewName": "test41",
                "idObject": {
                  "id": 1,
                  "name": "test,test2,test3,test41"
                }
              },
              {
                "viewName": "test44",
                "idObject": {
                  "id": 2,
                  "name": "test,test2,test3,test44"
                }
              }
            ]
          },
          {
            "viewName": "test4",
            "children": [
              {
                "viewName": "test5",
                "children": [
                  {
                    "viewName": "test8",
                    "idObject": {
                      "id": 6,
                      "name": "test,test2,test4,test5,test8"
                    }
                  }
                ]
              },
              {
                "viewName": "test6",
                "children": [
                  {
                    "viewName": "test10",
                    "idObject": {
                      "id": 11,
                      "name": "test,test2,test4,test6,test10"
                    }
                  },
                  {
                    "viewName": "test7",
                    "idObject": {
                      "id": 10,
                      "name": "test,test2,test4,test6,test7"
                    }
                  }
                ]
              }
            ],
            "idObject": {
              "id": 3,
              "name": "test,test2,test4"
            }
          }
        ]
      }
    ]
  },
  {
    "viewName": "test2",
    "children": [
      {
        "viewName": "test3",
        "children": [
          {
            "viewName": "test4",
            "idObject": {
              "id": 4,
              "name": "test2,test3,test4"
            }
          },
          {
            "viewName": "test5",
            "children": [
              {
                "viewName": "test6",
                "idObject": {
                  "id": 8,
                  "name": "test2,test3,test5,test6"
                }
              }
            ],
            "idObject": {
              "id": 7,
              "name": "test2,test3,test5"
            }
          }
        ]
      }
    ]
  }
]
thanks gt4dev ;
