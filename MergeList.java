����   8 [  unit7pre/MergeList  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7pre/MergeList; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   Enter list1:
 " $ # java/io/PrintStream % & print (Ljava/lang/String;)V
  ( ) * nextInt ()I , Enter list2: . The merge list is 
  0 1 2 merge ([I[I)[I 4 java/lang/StringBuilder
 6 8 7 java/lang/String 9 : valueOf (I)Ljava/lang/String;
 3 <  & >  
 3 @ A B append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 3 D E F toString ()Ljava/lang/String; args [Ljava/lang/String; input Ljava/util/Scanner; sum1 I list1 [I i sum2 list2 x StackMapTable H N i1 i2 list 
SourceFile MergeList.java !               /     *� �    
                    	      �  
   �� Y� � L� � !+� '=�
N6� -+� 'O���� +� !+� '6�
:6� +� 'O���� -� !-� /Y:	�66� '	.6� � 3Y� 5� ;=� ?� C� !���ر    
   J      	  
     "  *  3  ;  A  G  M  V  `  h  �  �  �     \ 	   � G H    � I J   � K L   � M N    O L  A e P L  G _ Q N  J  O L  �  R L  S   9 � "  T  U  
�  U�   
 T  U U  U  # 	 1 2    G     u=>6*�+�`�
:� (*.+.� *.O�� +.O��*�� +���ҧ *.O��*���� +.O��+�����    
   Z           !  " $ # ' $ * % 2 & 5 ( 8   D * G + O , R - U * [ / ^ 0 f 1 i 2 l / r 4    >    u M N     u Q N   s V L   q W L   n O L   e X N  S    �   U U U  
  Y    Z