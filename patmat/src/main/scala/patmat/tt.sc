object tt {

//  def times(chars: List[Char]): List[(Char, Int)] = {
////    chars.groupBy(identity).mapValues(_.size).toList
//
//    chars.groupBy(_).count()
//
//  }
//
//
//  times(List('a', 'b', 'a'))
  List('a', 'b', 'a').groupBy(c=>c).mapValues(_.size).toList

  List(('a', 2), ('e', 1), ('x', 3)).sortBy(x => x._2)



}
