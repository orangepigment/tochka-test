package ru.tochka.test.task2

object TreeNode {

  def isSameTree[X](p: Option[TreeNode[X]], q: Option[TreeNode[X]]): Boolean = {
    (p, q) match {
      case (None, None) => true
      case (Some(node), Some(anotherNode)) if node.value == anotherNode.value =>
        // Can lead to StackOverflow on large trees
        // This can be fixed by introducing a list of nodes to process and converting the method to a tail-recursive one
        isSameTree(node.left, anotherNode.left) && isSameTree(node.right, anotherNode.right)
      case _ => false
    }
  }

}

case class TreeNode[X](value: X, left: Option[TreeNode[X]], right: Option[TreeNode[X]])
