����   8 �  unit7pre/CouponCollector  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lunit7pre/CouponCollector; main ([Ljava/lang/String;)V
     	choosePai ([Z)Ljava/lang/String;
    java/lang/String   hashCode ()I  Hearts
     equals (Ljava/lang/Object;)Z ! Spades # 	Diammonds % Clubs	 ' ) ( java/lang/System * + out Ljava/io/PrintStream; - java/lang/StringBuilder / Number of picks:
 , 1  2 (Ljava/lang/String;)V
 , 4 5 6 append (I)Ljava/lang/StringBuilder;
 , 8 9 : toString ()Ljava/lang/String;
 < > = java/io/PrintStream ? 2 println args [Ljava/lang/String; color [Z flag Z count I StackMapTable C K Diamonds M Ace O 2 Q 3 S 4 U 5 W 6 Y 7 [ 8 ] 9 _ 10 a Jack c Queen e King
 g i h java/lang/Math j k random ()D
  m n o valueOf &(Ljava/lang/Object;)Ljava/lang/String; q  of 
 , s 5 t -(Ljava/lang/String;)Ljava/lang/StringBuilder; deck [I Huases ranks i index temp Huase Ljava/lang/String; rank v A 
SourceFile CouponCollector.java !               /     *� �    
                    	      y     ��L=>� �+3� +3� +3� +3� =� �+� Y:� �    w   ��   *��    7����   D�]   Q� � 4� C � �  � 6"� � !� )$� � � +T� +T� +T� +T���^� &� ,Y.� 0� 3� 7� ;�    
   N          	  
 #  %  (  �  �  �  �  �  �  �  �  � 	 �  �     *    � @ A    � B C   � D E   � F G  H    �  I� 3 �  	          �4�
L� Y SYSYJSY$SM� YLSYNSYPSYRSYTSYVSYXSYZSY\SY	^SY
`SYbSYdSN6� +O�+����6� $� f+��k�6+.6++.O+O�+���۸ f+��k�6,+.l2:-+.p2:Y:� �        ��   ,��    9��m�   F�]   S� � Y� � � �  � �J� � k� �$� � �� �*3� �� &� ,Y� l� 0p� r� r� 7� ;*T� �*3� ~� &� ,Y� l� 0p� r� r� 7� ;*T� X*3� R� &� ,Y� l� 0p� r� r� 7� ;*T� ,*3� &� &� ,Y� l� 0p� r� r� 7� ;*T�    
   r    "  #  $ l ' r ( x ' � , � - � . � / � 0 � , � 4 � 5 � 6 � 78 9> :a ;d =j >� ?� A� B� C� E� F� I    p   � B C   � u v  � w A  l| x A  o  y G  � + y G  �  z G  �  { G  �. y G  �# | }  � ~ }  H   / � r  I  � �   � Z   +++� (  �    �