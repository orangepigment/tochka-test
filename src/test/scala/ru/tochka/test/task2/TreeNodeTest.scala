package ru.tochka.test.task2

import ru.tochka.test.task2.TreeNode.isSameTree

object TreeNodeTest extends App {

  val simpleP = TreeNode(1, None, None)
  val simpleQ = TreeNode(1, None, None)
  assert(isSameTree(Some(simpleP), Some(simpleQ)), s"isSameTree($simpleP, $simpleQ) was false")

  val p = TreeNode(1, Some(TreeNode(2, None, None)), None)
  val q = TreeNode(1, None, Some(TreeNode(2, None, None)))
  assert(!isSameTree(Some(p), Some(q)), s"isSameTree($p, $q) was true")

  assert(isSameTree(None, None), s"isSameTree(None, None) was false")

}
