����   8 L  unit7pre/SortStudent  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7pre/SortStudent; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   请输入学生个数：
 " $ # java/io/PrintStream % & print (Ljava/lang/String;)V
  ( ) * nextInt ()I , java/lang/String . 请输入学生的姓名：
  0 1 2 next ()Ljava/lang/String; 4 !请依次输入学生的成绩：
 " 6 7 & println args [Ljava/lang/String; input Ljava/util/Scanner; sum I name score [I i j temp temp2 Ljava/lang/String; x StackMapTable 9 @ 
SourceFile SortStudent.java !               /     *� �    
                    	      ;  	   � Y� � L� � !+� '=� +N�
:� -� !6� -+� /S���� 3� !6� +� 'O����6� ]6� I.`.� 7.6`.O`O-2:--`2S-`S�dd����d���-Y:�66� 2:� � 5����    
   r      
       "  *  0  8  A  I  O  X  a  g  m  |  �  �  �   � ! � " �  �  � ' � ( � ' � *    z    � 8 9    � : ;   � < =   � > 9  " � ? @  -  A =  L  A =  d e A =  j T B =  � - C =  �  D E  �  F E  G   A � 0  H  H I  
� � B� �  	 H  H I  H    J    K